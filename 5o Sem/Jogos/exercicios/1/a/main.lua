LG = love.graphics

function love.load()
    Meiox = LG.getWidth() / 2
    Meioy = LG.getHeight() / 2
end

function love.draw()
    LG.setColor(1, 1, 1)
    LG.circle("fill", Meiox, Meioy, Meioy)
end