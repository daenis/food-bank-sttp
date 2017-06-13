const jsonServer = require('json-server')
const fs = require('fs')
const cors = require('cors')

function server () {
  const uri = process.cwd() + '/src/test-utils/'
  const db = JSON.parse(fs.readFileSync(uri + 'db.json', 'utf8'))
  this.server = jsonServer.create()
  this.defaults = jsonServer.defaults()
  this.routes = jsonServer.router(db)
  // this.server.use(this.defaults)
  // this.server.use(this.routes)
  this.server.use('/data/', this.defaults)
  this.server.use('/data/', this.routes)
  this.server.use(cors())
  this.server.get('/api/categories/', (req, res) => {
    const items = []
    let ctg = db.product.map(e => e.category).filter(e => {
      if (items.indexOf(e) === -1) {
        items.push(e)
        return true
      }
    })
    res.json({categories: ctg.sort()})
  })
  this.server.get('/api/categories/:type', (req, res) => {
    let ctg = db.product.filter(e => req.params.type.localeCompare(e.category) === 0)
    console.log(req.params)
    res.json({categories: ctg})
  })
  this.server.listen(6700, () => {
    console.log('JSON Server is running')
  })
}

server()
