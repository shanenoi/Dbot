from os        import listdir, system
from re        import search,sub
from requests  import get, post
import sys

sys.stdout = open("export.csv", "w")

links = """compile_ada_online.php
execute_algol_online.php
try_angularjs_online.php
compile_assembly_online.php
execute_awk_online.php
execute_bash_online.php
compile_befunge_online.php
execute_brainfk_online.php
compile_c_online.php
execute_cbasic_online.php
execute_clojure_online.php
compile_cobol_online.php
execute_coldfusion_online.php
compile_c99_online.php
compile_cpp_online.php
compile_cpp0x_online.php
compile_cpp11_online.php
compile_csharp_online.php
execute_dart_online.php
compile_d_online.php
compile_embedded_c_online.php
compile_erlang_online.php
execute_elixir_online.php
execute_factor_online.php
execute_fantom_online.php
execute_falcon_online.php
compile_fortran_online.php
execute_forth_online.php
compile_fsharp_online.php
compile_freebasic_online.php
execute_groovy_online.php
execute_golang_online.php
execute_haxe_online.php
compile_haskell_online.php
compile_ilasm_online.php
compile_intercal_online.php
compile_icon_online.php
compile_java_online.php
compile_java8_online.php
compile_jdbc_online.php
execute_jsp_online.php
execute_julia_online.php
execute_jython_online.php
compile_kotlin_online.php
execute_ksh_online.php
execute_lisp_online.php
execute_lolcode_online.php
execute_lua_online.php
execute_matlab_online.php
execute_malbolge_online.php
compile_mozart-oz_online.php
compile_nimrod_online.php
execute_nodejs_online.php
compile_objective-c_online.php
compile_ocaml_online.php
oracle_terminal_online.php
compile_pascal_online.php
execute_pari_online.php
compile_pawn_online.php
execute_perl_online.php
perl_mysql_online.php
execute_php_online.php
php_mysql_online.php
php_webview_online.php
execute_pike_online.php
execute_prolog_online.php
execute_python_online.php
execute_python3_online.php
python_mysql_online.php
execute_rexx_online.php
execute_ruby_online.php
ruby_mysql_online.php
compile_rust_online.php
execute_r_online.php
compile_scala_online.php
execute_scheme_online.php
execute_smalltalk_online.php
execute_smlnj_online.php
compile_simula_online.php
execute_sql_online.php
compile_swift_online.php
execute_tcl_online.php
execute_unlambda_online.php
compile_vb.net_online.php
compile_verilog_online.php
execute_whitespace_online.php
execute_basic_online.php""".split("\n")

def get_source(link, method="GET", params={}):
    link = sub("([^:/]+)/+", '\\1/', link)

    requests_method = {"GET": get, "POST": post}

    folder_cache = "cache_els"
    system(f"mkdir {folder_cache} 2>/dev/null")
    name_ = f"{link}|{str(params)}".replace('/', '|')
    if name_ in listdir(folder_cache):
        return open(f"{folder_cache}/{name_}").read()
    else:
        source = requests_method[method](link, data=params).text
        open(f"{folder_cache}/{name_}", 'w').write(source)
        return source
    
def get_details(source):
    result = {}
    result['lang'] = search('var langid = "([^"]+)";', source).groups()[0]
    result['device'] = ""
    result['code'] = ""
    result['stdinput'] = ""
    result['ext'] = search('var ext = "([^"]+)";', source).groups()[0]
    result['compile'] = search('var compile = "([^"]+)";' , source).groups()[0]
    result['execute'] = search('var execute = "([^"]+)";', source).groups()[0]
    result['mainfile'] = search('var mainfile = "([^"]+)";', source).groups()[0]
    result['uid'] = ""
    return result

data = {}
remove = []
for link in links:
    try:
        _ = search("[^/_]+_([^/_]+)_[^/_]+", link).groups()[0]
        data[_] = get_details(get_source(f"https://www.tutorialspoint.com/{link}"))
    except AttributeError:
        pass

for removal in remove:
    data.pop(removal)

print('lang|device|code|stdinput|ext|compile|execute|mainfile|uid')
for i in data:
    print(f'{data[i]["lang"]}|{data[i]["device"]}|'
          f'{data[i]["code"]}|{data[i]["stdinput"]}|'
          f'{data[i]["ext"]}|{data[i]["compile"]}|'
          f'{data[i]["execute"]}|{data[i]["mainfile"]}|'
          f'{data[i]["uid"]}')
