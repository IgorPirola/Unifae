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
    personagem.imgesq = LG.newImage('sprite-esq.png')
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
    LG.draw(padrao and personagem.imgdir or personagem.imgesq, quadros[direcao][passo], personagem.x, personagem.y)
end

function love.update(dt)
    if not status then
        tempo = tempo + dt
        if tempo > 0.2 then
            tempo = 0.1
            -- Animação do Quad até o limite de imagens (8)
            passo = passo + 1
            if direcao == 'right' then
                personagem.x = personagem.x + 5
            elseif direcao == 'left' then
                personagem.x = personagem.x - 5
            end
            -- Verificação do máximo Quad
            if passo > max then
                passo = 1
            end
        end
    end    
end

function love.keypressed(tecla)
    if quadros[tecla] then
        direcao = tecla 
        status = false
    end
    padrao = (tecla == 'right')
end

function love.keyreleased(tecla)
    if quadros[tecla] and direcao == tecla then
        status = true
        passo = 1
        direcao = 'right'
        padrao = true
    end
end
