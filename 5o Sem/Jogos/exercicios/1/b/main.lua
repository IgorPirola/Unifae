LG = love.graphics

function love.load()
    Meiox = LG.getWidth() / 2
    Meioy = LG.getHeight() / 2
    TrintaPorcento = LG.getWidth() * 0.3
    VinteCincoPorcento = LG.getHeight() * 0.25
end

function love.draw()
    LG.setColor(1, 1, 1)
    LG.rectangle("fill", Meiox, Meioy, 100, 300)
end