const jsonServer = require('json-server')
const fs = require('fs')
const cors = require('cors')

function server () {
  const uri = process.cwd() + '/src/test-utils/'
  const db = JSON.parse(fs.readFileSync(uri + 'db.json', 'utf8'))
  this.server = jsonServer.create()
  this.router = jsonServer.defaults()
  this.middleware = jsonServer.router(db)
  this.server.use(this.router)
  this.server.use(this.middleware)
  this.server.use(cors())
  this.server.listen(6700, () => {
    console.log('JSON Server is running')
  })
}

server()
