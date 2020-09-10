package org.shanenoi.Dbot.rextester;

import okhttp3.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.HashMap;

public class Rextester {

    public enum Languages {
        ADA("39"),         LUA("14"),        ASSEMBLY("15"),    MYSQL("33"),
        BASH("38"),        NODE_JS("23"),    C_SHARP("1"),      OCAML("42"),
        CPP_GCC("7"),      OCTAVE("25"),     CPP_CLANG("27"),   OBJECTIVE_C("10"),
        CPP_VC("28"),      ORACLE("35"),     C_GCC("6"),        PASCAL("9"),
        C_CLANG("26"),     PERL("13"),       C_VC("29"),        PHP("8"),
        CLIENT_SIDE("36"), POSTGRESQL("34"), CLOJURE("47"),     PROLOG("19"),
        COMMON_LISP("18"), PYTHON("5"),      D("30"),           PYTHON_3("24"),
        ELIXIR("41"),      R("31"),          ERLANG("40"),      RUST("46"),
        F_SHARP("3"),      RUBY("12"),       FORTRAN("45"),     SCALA("21"),
        GO("20"),          SCHEME("22"),     HASKELL("11"),     SQL_SERVER("16"),
        JAVA("4"),         SWIFT("37"),      JAVASCRIPT("17"),  TCL("32"),
        KOTLIN("43"),      VISUAL_BASIC("2");
        public String value;
        Languages(String value) {this.value = value;}
    }

    public static class CodeContainer{
        public Request request;
        public RequestBody requestBody;
        public Map<String, Map<String, String>> args = new HashMap<>();

        private static String encodeValue(String value) {
            try {return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());}
            catch (UnsupportedEncodingException ex) {throw new RuntimeException(ex.getCause());}
        }

        public CodeContainer(){
            Map<String, String> params = new HashMap<>();
            params.put("LayoutChoiceWrapper", "2"); params.put("Input","");
            params.put("ShowWarnings", "false");    params.put("Privacy","");
            params.put("PrivacyUsers","");          params.put("Title","");
            params.put("SavedOutput","");           params.put("WholeError","");
            params.put("WholeWarning","");          params.put("StatsToSave","");
            params.put("CodeGuid","");              params.put("IsInEditMode", "False");
            params.put("IsLive", "False");          params.put("EditorChoiceWrapper", "1");
            params.put("CompilerArgs", "-Wall+-std=gnu99+-O2+-o+a.out+source_file.c");
            args.put("params", params);
        }

        public void loadData() {
            String tempString = "";
            for (String key: this.args.get("params").keySet()) {
                tempString = tempString.concat(
                                String.format(
                                        "%s=%s&", CodeContainer.encodeValue(key),
                                        CodeContainer.encodeValue(this.args.get("params").get(key))));
            }this.requestBody = RequestBody.create(tempString,MediaType.parse("application/x-www-form-urlencoded"));
        }

    }

    OkHttpClient client = new OkHttpClient().newBuilder().build();

    public CodeContainer set_args(String type, CodeContainer container, Map<String, String> type_args, boolean reset){
        if (reset) {container.args.replace(type, type_args);}
        else {type_args.keySet().forEach(key -> container.args.get(type).put(key, type_args.get(key)));}
        return container;
    }

    public Response send(CodeContainer container){
        container.loadData();
        container.request = new Request.Builder()
                .url("https://rextester.com/rundotnet/Run")
                .method("POST", container.requestBody).build();
        try {return this.client.newCall(container.request).execute();}
        catch (IOException error) {System.out.println("Error!");
            return null;
        }
    }

}
