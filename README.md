# cljs-exe

cljs-exe is a Boot template to create a Clojurescript
application that will compile to a native binary using
[nexe](https://github.com/nexe/nexe).

[![Clojars Project](https://img.shields.io/clojars/v/cljs-exe/lein-template.svg)](https://clojars.org/cljs-exe/lein-template)

## Motivation

[nexe](https://github.com/nexe/nexe), on which this project is based, lists these reasons:

- Ability to run multiple applications with different node.js runtimes.
- Distributable binaries without needing node / npm.
- Starts faster.
- Lockdown specific application versions, and easily rollback.
- Faster deployments.

I'll second those and add: "In ClojureScript."

## Quickstart

You will need
- [Boot](https://github.com/boot-clj/boot)
- [NodeJS](https://nodejs.org/)
- [Python](https://www.python.org/) somewhere on your path (it is an nexe dependency)

```
$ brew install boot-clj
$ boot -d boot/new new -S -t cljs-exe -n your_project_name
$ cd your_project_name
$ boot package
```

This will compile some sample Clojurescript code to Javascript, then compiling the Javascript to a native binary.

## Tasks

This project template gives you a few boot tasks:

- `build`: runs the Clojurescript compiler with defaults that include: fetching npm dependencies that are listed in the `js-dependencies` var in `build.boot`, emitting source maps, and no compiler optimizations.
- `dev`: runs `build` in a watch loop, rerunning `build` anytime you change a source file.
- `binary`: compiles the current project Javascript into a native binary on your platform.
- `package`: compiles Clojurescript to Javascript with `simple` compiler optimizations and no source maps, then compiles that Javascript to a native binary on your platform.

