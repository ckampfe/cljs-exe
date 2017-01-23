# cljs-exe

cljs-exe is a Boot template to create a Clojurescript
application that will compile to a native binary using
[nexe](https://github.com/nexe/nexe).

[![Clojars Project](https://img.shields.io/clojars/v/cljs-exe.svg)](https://clojars.org/cljs-exe)

## Create a new project

Install [boot](https://github.com/boot-clj/boot), then:

If snapshot release:

```
$ boot -d seancorfield/boot-new new -S -t cljs-exe -n your-project-name
```

If regular release:

```
$ boot -d seancorfield/boot-new new -t cljs-exe -n your-project-name
```

## Configuration

See generated project for full configuration information.
