local LG = love.graphics
local LQ = love.graphics.newQuad

local personagem = {}
local quadros = {}
local qLarg, qAlt = 32, 32
local sLarg, sAlt = 256, 32

local direcao = 'right'
local padrao = true 
local passo = 1
local max = 8
local status = true
local tempo = 0.1

function love.load()
    LG.setBackgroundColor(1,1,1)
    personagem.imgdir = LG.newImage('sprite-dir.png')
    personagem.imgesq = LG.newImage('sprite-dir.png')
    personagem.x = 100
    personagem.y = 200

    quadros['right'] = {}
    quadros['left'] = {}
    for c = 1,8 do
        quadros['right'][c] = LQ((c-1)*32,0, qLarg, qAlt, sLarg, sAlt)
        quadros['left'][c] = LQ((c-1)*32,0, qLarg, qAlt, sLarg, sAlt)
    end
end

function love.draw()
    LG.draw(personagem.imgdir, quadros[direcao][passo], personagem.x, personagem.y)
end