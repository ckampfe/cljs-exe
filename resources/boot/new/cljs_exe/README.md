# {{name}}

## Requirements

- [Boot](https://github.com/boot-clj/boot)
- [NodeJS](https://nodejs.org/)
- [Python](https://www.python.org/) somewhere on your path (it is an nexe dependency)

## Usage


This project template gives you a few boot tasks:

- `build`: runs the Clojurescript compiler with defaults that include: fetching npm dependencies that are listed in the `js-dependencies` var in `build.boot`, emitting source maps, and no compiler optimizations.
- `dev`: runs `build` in a watch loop, rerunning `build` anytime you change a source file.
- `binary`: compiles the current project Javascript into a native binary on your platform.
- `package`: compiles Clojurescript to Javascript with `simple` compiler optimizations and no source maps, then compiles that Javascript to a native binary on your platform.


## Configuration

Configure the build in `build.boot`.

Configure the Javascript compilation in `scripts/build.js`.

