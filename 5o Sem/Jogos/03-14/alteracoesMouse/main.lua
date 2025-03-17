local mensagem = " nenhum "

function love.load()
    love.graphics.setFont(love.graphics.newFont(20))

    cursor = love.mouse.newCursor('icoMouse.png')
    love.mouse.setCursor(cursor)
end

function love.draw()
    love.graphics.print('Pressione qualquer tecla para sortear a posição do mouse', 50, 50)
    
    if love.mouse.isDown(1) then
        mensagem = " esquerdo "
    elseif love.mouse.isDown(2) then
        mensagem = " direito "
    elseif love.mouse.isDown(3) then
        mensagem = " central "
    end
    love.graphics.print("Botão" .. mensagem .. "pressionado!", 100, 100)
end

function love.keypressed(tecla)
    local x, y = math.random(0, 600)
    love.mouse.setPosition(x, y)
end