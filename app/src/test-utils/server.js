const child_process = require('child_process')

class Server {
  constructor () {
    const workingDir = process.cwd()
    this.server = child_process.spawn('node',
      ['./json-server.js'],
      { cwd: workingDir + '/src/test-utils' })
  }

  kill () {
    this.server.kill()
  }
}

module.exports = { Server: Server }
