package org.shanenoi.Dbot;

import org.shanenoi.Dbot.rextester.Rextester;
import org.shanenoi.Dbot.rextester.Rextester.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

    public static void testEnumLang() {
        System.out.print(Languages.ADA.value);
        System.out.print(Languages.LUA.value);
        System.out.print(Languages.ASSEMBLY.value);
        System.out.print(Languages.MYSQL.value);
        System.out.print(Languages.BASH.value);
        System.out.print(Languages.NODE_JS.value);
        System.out.print(Languages.C_SHARP.value);
        System.out.print(Languages.OCAML.value);
        System.out.print(Languages.CPP_GCC.value);
        System.out.print(Languages.OCTAVE.value);
        System.out.print(Languages.CPP_CLANG.value);
        System.out.print(Languages.OBJECTIVE_C.value);
        System.out.print(Languages.CPP_VC.value);
        System.out.print(Languages.ORACLE.value);
        System.out.print(Languages.C_GCC.value);
        System.out.print(Languages.PASCAL.value);
        System.out.print(Languages.C_CLANG.value);
        System.out.print(Languages.PERL.value);
        System.out.print(Languages.C_VC.value);
        System.out.print(Languages.PHP.value);
        System.out.print(Languages.CLIENT_SIDE.value);
        System.out.print(Languages.POSTGRESQL.value);
        System.out.print(Languages.CLOJURE.value);
        System.out.print(Languages.PROLOG.value);
        System.out.print(Languages.COMMON_LISP.value);
        System.out.print(Languages.PYTHON.value);
        System.out.print(Languages.D.value);
        System.out.print(Languages.PYTHON_3.value);
        System.out.print(Languages.ELIXIR.value);
        System.out.print(Languages.R.value);
        System.out.print(Languages.ERLANG.value);
        System.out.print(Languages.RUST.value);
        System.out.print(Languages.F_SHARP.value);
        System.out.print(Languages.RUBY.value);
        System.out.print(Languages.FORTRAN.value);
        System.out.print(Languages.SCALA.value);
        System.out.print(Languages.GO.value);
        System.out.print(Languages.SCHEME.value);
        System.out.print(Languages.HASKELL.value);
        System.out.print(Languages.SQL_SERVER.value);
        System.out.print(Languages.JAVA.value);
        System.out.print(Languages.SWIFT.value);
        System.out.print(Languages.JAVASCRIPT.value);
        System.out.print(Languages.TCL.value);
        System.out.print(Languages.KOTLIN.value);
        System.out.print(Languages.VISUAL_BASIC.value);
    }

    public static void testRequest() throws IOException {
        /* check CodeContainer */
        CodeContainer code = new CodeContainer();
        /* check Rextester */
        Rextester rex = new Rextester();
        Map<String, String> details = new HashMap<>();
        details.put("Program","print('Hello')");
        details.put("LanguageChoiceWrapper",Languages.PYTHON.value);
        code = rex.set_args("params", code, details, false);
        System.out.println(Objects.requireNonNull(rex.send(code).body()).string());
    }

    public static void main(String[] args) throws IOException {
        testEnumLang();
        testRequest();

    }

}
