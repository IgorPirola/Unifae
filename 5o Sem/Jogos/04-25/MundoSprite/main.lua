LG = love.graphics

Q = LG.newQuad
K = love.keyboard.isDown

local Mapa
local MLarg, MAlt
local MX, MY
local VisaoLarg, VisaoAlt
local ZX, ZY

local QDImagem, QDTam
Quadros = {}
local LoteQuadros

function love.load()
    local fonte = LG.newFont(14)
    LG.setFont(fonte)
    configMapa() -- mundo virtual
    configVisao() -- viewport, janela de visão
    configQuadros() -- gestão dos ladrilhos
end

function love.draw()
    LG.draw(LoteQuadros, math.floor(-ZX * (MX % 1) * QDTam), math.floor(-ZY * (MY % 1) * QDTam), 0, ZX, ZY)
    LG.print("FPS: " .. love.timer.getFPS(), 10, 20)
end

function love.update(dt)
    if K('up') then
        moverMapa(0, -0.2 * QDTam * dt)
    elseif K('down') then
        moverMapa(0, 0.2 * QDTam * dt)
    end

    if K('left') then
        moverMapa(-0.2 * QDTam * dt, 0)
    elseif K('right') then
        moverMapa(0.2 * QDTam * dt, 0)
    end

end

function configMapa()
    MLarg = 60
    MAlt = 40

    Mapa = {}
    for x = 1, MLarg do
        Mapa[x] = {}
        for y = 1, MAlt do
            Mapa[x][y] = love.math.random(0, 3)
        end
    end

end

function configVisao()
    MX = 1
    MY = 1
    VisaoLarg = 26
    VisaoAlt = 20
    ZX = 1
    ZY = 1

end

function configQuadros()
    QDImagem = LG.newImage('mundo.png')
    QDImagem:setFilter('nearest', 'linear')
    QDTam = 32

    local L, A = QDImagem:getWidth(), QDImagem:getHeight()
    -- Coletar os ladrilhos (Sprite)

    -- Area gramada
    Quadros[0] = Q(0 * QDTam, 20 * QDTam, QDTam, QDTam, L, A)

    -- Area Xadres cinza
    Quadros[1] = Q(2 * QDTam, 0 * QDTam, QDTam, QDTam, L, A)

    -- Area piso marrom
    Quadros[2] = Q(4 * QDTam, 0 * QDTam, QDTam, QDTam, L, A)

    -- Area tapete vermelho
    Quadros[3] = Q(3 * QDTam, 9 * QDTam, QDTam, QDTam, L, A)

    -- Criar lote de quadros
    LoteQuadros = LG.newSpriteBatch(QDImagem, VisaoLarg * VisaoAlt)
    modificaLote()

end

function modificaLote()
    -- Limpar lote
    LoteQuadros:clear()

    -- Atualizar os quadros

    for x = 0, VisaoLarg - 1 do 
        for y = 0, VisaoAlt - 1 do
            LoteQuadros:add(Quadros[Mapa[x + math.floor(MX)][y + math.floor(MY)]], x * QDTam, y * QDTam)
        end
    end

    -- Atualizar a carga
    LoteQuadros:flush()
end

function moverMapa(dx, dy)
    local velhoX, velhoY = MX, MY

    MX = math.max(math.min(MX + dx, MLarg - VisaoLarg), 1)
    MY = math.max(math.min(MY + dy, MAlt - VisaoAlt), 1)

    if math.floor(MX) ~= math.floor(velhoX) or math.floor(MY) ~= math.floor(velhoY) then
        modificaLote()
    end

end