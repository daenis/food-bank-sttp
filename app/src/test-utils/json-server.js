const jsonServer = require('json-server')

function server () {
  console.log(process.cwd())
  this.server = jsonServer.create()
  this.router = jsonServer.defaults('routes.json')
  this.middleware = jsonServer.router('db.json')
  this.server.use(this.router)
  this.server.use(this.middleware)
  this.server.listen(6700, () => {
    console.log('JSON Server is running')
  })
}

server()
