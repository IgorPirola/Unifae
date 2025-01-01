const sequelize = require('sequelize')
const connection = require('./database')

const pergunta = connection.define('pergunta', {
    titulo:{
        type: sequelize.STRING,
        allowNull: false
        //primaryKey: true,
        //autoIncrement: true
    },
    descricao:{
        type: sequelize.TEXT,
        allowNull: false
    }
})

pergunta.sync({force: false}).then(()=> {
    console.log("Tabela de perguntas criada!")
})

module.exports = pergunta
