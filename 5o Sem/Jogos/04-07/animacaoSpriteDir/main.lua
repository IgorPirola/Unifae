LG = love.graphics


local personagem
local quadros = {}
local tempo = 0.1
local atual = 1

function love.load()
    LG.setBackgroundColor(1,1,1)
    personagem = LG.newImage('sprite-dir.png')
    --Q01 = LG.newQuad(0,0, 32,32, 256,32)
    --Q02 = LG.newQuad(32, 0, 32,32, 256,32)

    --Automatizar a definição dos Quadriláteros
    for c = 1,8 do
        quadros[c] = LG.newQuad((c-1)*32,0, 32,32, 256,32)
    end
end

function love.draw()
    --LG.draw(personagem, 10, 300)
    --LG.draw(personagem, Q01, 50,50)
    --LG.draw(personagem, Q02, 50,100)
    -- for c = 1,8 do
    --     LG.draw(personagem, quadros[c], 50, c*50)
    -- end
    
    LG.draw(personagem, quadros[atual], 350, 300)
end

function love.update(dt)
    --Timer para troca de quadros
    tempo = tempo + dt
    if tempo > 0.2 then
        tempo = 0.1
        atual = atual + 1
        if atual > 8 then
            atual = 1
        end
    end
end