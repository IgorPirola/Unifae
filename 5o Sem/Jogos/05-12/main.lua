LA = love.audio
LG = love.graphics

function love.load()
    musica = love.audio.newSource("audio/musica.ogg", "stream")
    musica:setLooping(true)
    musica:play()

    efeito1 = LA.newSource("audio/efeito.ogg", 'static')
    efeito2 = LA.newSource("audio/tiro.wav", 'static')
    efeito3 = LA.newSource("audio/buzina.mp3", 'static')
    efeito4 = LA.newSource("audio/computador.mp3", 'static')

    vibe = LG.newVideo("audio/karatecasimples.ogv")
    vibe:play()
end

function love.draw()
    LG.draw(vibe, 75, 100, 0, 1, 1)
    LG.print(tostring(atual), 0,0)
end


function love.keypressed(tecla)
    if tecla == 'm' then
        musica:play()
    end

    if tecla == 'space' then
        musica:stop()
    end

    if tecla == 'g' then
        efeito1:play()
    end

    if tecla == 't' then
        efeito2:play()
    end

    if tecla == 'b' then
        efeito3:play()
    end

    if tecla == 'c' then
        efeito4:play()
    end

    if tecla == 'up' or tecla == 'down' then
        atual = musica.getVolume()
        if tecla == 'up' then
            atual = atual + 0.1
        elseif tecla == 'down' then
            atual = atual - 0.1
        end
        musica:setVolume(atual)
    end

    if tecla == 'left' or tecla == 'right' then
        atual = musica:getPitch()
        if tecla == 'left' then
            atual = atual - 0.1
        elseif tecla == 'right' then
            atual = atual + 0.1
        end
    end

end
