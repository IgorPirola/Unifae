const express = require("express"); 
const app = express(); 

const bodyParser = require('body-parser')

const connection = require('./database/database')

const perguntaModel = require('./database/pergunta')

//Banco de dados
connection.
    authenticate(). 
    then(()=> {
        console.log("Conectado ao bando de dados!")
    })
    .catch((msgErro)=> {
        console.log("msgErro")
    })

app.use(bodyParser.urlencoded({extended:false}))
app.use(bodyParser.json())

app.set('view engine', 'ejs');

app.use(express.static('public'));

app.post('/savequestion', (req, res) =>{
    var titulo = req.body.titulo
    var descricao = req.body.descricao

    //res.send("Formulario recebido! Titulo: "+ titulo + " com descrição: "+ descricao)
    perguntaModel.create({
        titulo: titulo,
        descricao: descricao
    }).then(()=> {
        res.redirect('/')
    })

})

app.get("/question", (req, res)=>{
    res.render('question')
})

app.get("/", (req, res)=>{
    perguntaModel.findAll({ raw:true }).then(perguntas =>{
        //console.log(perguntas)
        res.render('index', {
            perguntas: perguntas
        })
    })

    
})
app.listen("8181", () => { 
    console.log("Servidor online"); 
})
