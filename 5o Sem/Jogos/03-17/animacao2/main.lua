local angulo = 0
local dimen = 100
local alt, larg, personagem, esc, dx, dy
local telaAlt, telaLarg

local bola = {}

function love.load()
    esc = .3
    love.graphics.setBackgroundColor(1, .88, .88)
    -- love.graphics.setColor(0,0,1,1)
    personagem = love.graphics.newImage('robo.jpg')
    alt, larg = personagem:getHeight(), personagem:getWidth()
    telaAlt, telaLarg = love.graphics.getHeight(), love.graphics.getWidth()
    dx, dy = larg / 2, alt / 2
    bola.img = love.graphics.newImage('bola.png')
    bola.posX = 25
    bola.posY = 500
    bola.larg = bola.img:getWidth()
end

function love.draw()
    --love.graphics.rotate(angulo)
    --love.graphics.rectangle('fill', 300,400, dimen, dimen)
    love.graphics.draw(personagem, telaLarg / 2, telaAlt / 2, angulo, esc, esc, dx, dy)
    love.graphics.draw(bola.img, bola.posX, bola.posY)
end

function love.update(dt)
    local delta = math.pi * dt
    -- H gira horario
    if love.keyboard.isDown('h') then
        angulo = angulo + delta
    end
    -- A gira anti-horario
    if love.keyboard.isDown('a') then
        angulo = angulo - delta
    end

    -- bola
    if bola.posX > (telaLarg - bola.larg) then
        bola.posX = telaLarg
    else
        bola.posX = bola.posX + 150 * dt
    end
end