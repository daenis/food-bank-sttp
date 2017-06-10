const jsonServer = require('json-server')

function server () {
  const uri = process.cwd() + '/src/test-utils/'
  this.server = jsonServer.create()
  this.router = jsonServer.defaults(uri + 'routes.json')
  this.middleware = jsonServer.router(uri + 'db.json')
  this.server.use(this.router)
  this.server.use(this.middleware)
  this.server.listen(6700, () => {
    console.log('JSON Server is running')
  })
}

server()
