const nexe = require('nexe');

const outputPath = 'target/out';

nexe.compile({
    input: 'target/js/app.js',
    output: outputPath,
    nodeTempDir: 'tmp',
    nodeConfigureArgs: [
      '--without-dtrace',
      '--without-npm',
      '--without-inspector',
      '--without-etw',
      '--without-perfctr',
    ],
    // nodeMakeArgs: ["-j", "4"], // when you want to control the make process.
    nodeVCBuildArgs: ['nosign', 'x64', 'noetw', 'noperfctr'], // when you want to control the make process for windows.
    // By default "nosign" option will be specified
    // You can check all available options and its default values here:
    // https://github.com/nodejs/node/blob/master/vcbuild.bat
    // resourceFiles: ["target"],
    // browserifyExcludes: "resources",
    resourceRoot: 'target/',
    flags: true, // use this for applications that need command line flags.
    jsFlags: [
      // '--use_strict',
      // '--prepare_always_opt',
      // '--always_opt',
      // '--compiled_keyed_generic_loads',
    ].join(' '),
    startupSnapshot: 'target/js/app.js',
    framework: 'node',
    nodeVersion: '7.4.0'
  }, err => {
    if (err) {
      throw err;
    }

    console.log(`Finished bundling. Nexe binary can be found at ${outputPath}`);
});
