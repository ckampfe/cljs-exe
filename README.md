# cljs-exe

cljs-exe is a Boot template to create a Clojurescript
application that will compile to a native binary using
[nexe](https://github.com/nexe/nexe).

[![Clojars Project](https://img.shields.io/clojars/v/cljs-exe.svg)](https://clojars.org/cljs-exe)

## Motivation

[nexe](https://github.com/nexe/nexe), on which this project is based, lists these reasons:

- Ability to run multiple applications with different node.js runtimes.
- Distributable binaries without needing node / npm.
- Starts faster.
- Lockdown specific application versions, and easily rollback.
- Faster deployments.

I'll second those and add: "In ClojureScript."

## Create a new project

Install [boot](https://github.com/boot-clj/boot), then:

If snapshot release:

```
$ boot -d boot/new new -S -t cljs-exe -n your-project-name
```

If regular release:

```
$ boot -d boot/new new -t cljs-exe -n your-project-name
```

## Configuration

See README.md in the generated project for full configuration information.
