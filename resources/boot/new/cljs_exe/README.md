# {{name}}

## Requirements

- Boot
- Yarn
- Python >= 2.6 (for [nexe](https://github.com/nexe/nexe))


## Usage

Fetch node dependencies:

```
$ boot setup
```

Compile Clojurescript to Javascript:

```
$ boot release
```

Compile Javascript to native executable:
```
$ boot package
```

Note: the first time you run `boot package`, `nexe` will download
and compile V8 for your platform.
This may take upwards of 20 minutes depending on your hardware.
Subsequent compilations should be <10 seconds.

Run the resulting binary:

```
$ ./target/out
```

## Configuration

Configure the build in `build.boot`.

Configure the Javascript compilation in `scripts/build.js`.

