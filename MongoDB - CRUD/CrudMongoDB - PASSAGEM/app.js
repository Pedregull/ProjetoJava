const express = require('express')
const app = express()
app.set('view ingine', 'ejs')
const bodyParser = require('body-parser')
const res = require('express/lib/response')
app.use(bodyParser.urlencoded({ extended: true }))

const MongoClient = require('mongodb').MongoClient
const ObjectId = require('mongodb').ObjectID

const caminho = "mongodb://localhost/Passagem"

MongoClient.connect(caminho, { useNewUrlParser: true, useUnifiedTopology: true }, (err, client) => {

    db = client.db('Passagem') // Buscando no servidor MongoDB o banco Usuário

})

//================= Metodo Inicial ======================== //
app.get('/', (req, res) => {

    res.render('index.ejs')
})

//================= Metodo GET ======================== //
app.get('/show', (req, res) => {
    db.collection('Cadastro').find().toArray((err, results) => {

        res.render('show.ejs', { data: results })

    })
})

//================= Metodo POST ======================== //
app.post('/show', (req, res) => {
    db.collection('Cadastro').insertOne(req.body, (err, result) => {
        res.redirect('/')
    })
}) +

    //============ Apagar dados ================ //
    app.route('/delete/:id')
        .get((req, res) => {
            var id = req.params.id

            db.collection('Cadastro').deleteOne({ _id: ObjectId(id) }, (err, result) => {
                if (err) return res.send(500, err)
                console.log('Deletado do Banco de Dados!')
                res.redirect('/show')
            })
        })

//===================== Atualizar dados =================== //
app.route('/edit/:id')
    .get((req, res) => {
        var id = req.params.id

        db.collection('Cadastro').find(ObjectId(id)).toArray((err, result) => {
            if (err) return res.send(err)
            res.render('edit.ejs', { data: result })
        })
    })
    .post((req, res) => {
        var id = req.params.id
        var name = req.body.name
        var preco = req.body.preco

        db.collection('Cadastro').updateOne({ _id: ObjectId(id) }, {
            $set: {
                name: name,
                preco: preco,
            }
        }, (err, result) => {
            if (err) return res.send(err)
            res.redirect('/show')
            console.log('Atualizado no Banco de Dados')
        })
    })

app.listen(3000, function () {
    console.log('Server rodando na porta 3000')
})