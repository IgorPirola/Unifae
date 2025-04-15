local LG = love.graphics
local LQ = LG.newQuad

function love.load()
    LG.setBackgroundColor(1,1,1)
    Sprite = LG.newImage('zombie.png')

    anima = geraAnimacao(Sprite, 430, 519, 1)
end

function love.draw()
    -- # é equivalente a length
    local pos = math.floor(anima.tempo / anima.duracao * #anima.quadros) + 1
    LG.draw(anima.img, anima.quadros[pos], 80, 10, 0, 1, 1)
end

function love.update(dt)
    anima.tempo = anima.tempo + dt
    if anima.tempo >= anima.duracao then
        anima.tempo = anima.tempo - anima.duracao 
    end
end

function geraAnimacao(img, larg, alt, duracao)
    -- Inicializar a tabela de animação
    anima = {}
    anima.img = img

    anima.quadros = {}

    for y = 0, img:getHeight() - alt, alt do
        for x = 0, img:getWidth() - larg, larg do
            table.insert(anima.quadros, LQ(x, y, larg, alt, img:getDimensions()))
        end
    end

    anima.duracao = duracao or 1
    anima.tempo = 0

    return anima
end