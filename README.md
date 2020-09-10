# Dbot
Automatical Bot
## _Rextester Poster_[release]

- **Available Languages**:
    + Ada
    + Assembly
    + Bash
    + C++ (gcc)
    + C++ (clang)
    + C++ (vc++)
    + C (gcc)
    + C (clang)
    + C (vc)
    + Client Side
    + Clojure
    + Common Lisp
    + D
    + Elixir
    + Erlang
    + F#
    + Fortran
    + Go
    + Haskell
    + Java
    + Javascript
    + Kotlin
    + Lua
    + MySql
    + Node.js
    + Ocaml
    + Octave
    + Objective-C
    + Oracle
    + Pascal
    + Perl
    + Php
    + PostgreSQL
    + Prolog
    + Python
    + Python 3
    + R
    + Rust
    + Ruby
    + Scala
    + Scheme
    + Sql Server
    + Swift
    + Tcl
    + Visual Basic

- **Exploit**
    ```java
    import org.shanenoi.Dbot.rextester.Rextester;
    import org.shanenoi.Dbot.rextester.Rextester.*;

    import java.io.IOException;
    import java.util.HashMap;
    import java.util.Map;
    import java.util.Objects;

    public class Main {

        public static void testRequest() throws IOException {
            Rextester rex = new Rextester();
            Map<String, String> details = new HashMap<>();
            details.put("Program","print('Hello')");
            details.put("LanguageChoiceWrapper",Languages.PYTHON.value);
            code = rex.set_args("params", code, details, false);
            System.out.println(Objects.requireNonNull(rex.send(code).body()).string());
        }

        public static void main(String[] args) throws IOException {
            testRequest();
        }

    }
    ```
