const nexe = require('nexe');

const outputPath = 'target/out';

nexe.compile({
  input: 'target/js/app.js',
  output: outputPath,
  resources: 'target/',
  flags: true, // use this for applications that need command line flags.
  snapshot: 'target/js/app.js',
  nodeVersion: '8.9.2'
}, err => {
  if (err) {
    throw err;
  }

  console.log(`Finished bundling. Nexe binary can be found at ${outputPath}`);
});
