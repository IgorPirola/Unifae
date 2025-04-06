--Apelidos--
LG = love.graphics
LK = love.keyboard
LM = love.mouse
LA = love.audio

--Variaveis Globais--
local personagem = {posX=0, poxY=0, veloc=150, img=nil}
ModoTurbo = false

--Estrutura para disparos--
local podeAtirar = true
local tempoTiroMax = 0.2
TiroAtual = tempoTiroMax
local imgDisparo = nil
local disparos = {} --Tabela de Disparos realizados

-- Estrutura para inimigos
local tempoInimMax = 0.4
InimAtual = tempoInimMax
local margemInimigo = 0
local imgInimigo = nil
local inimigos = {} -- tabela de inimigos na tela
local velocInimigo = 200

-- Controle de pontuação e Game Over
Vivo = true
Pontos = 0

function love.load()
  --Carga do Cenario--
  Fundo = LG.newImage('Insumos/Espaco.png')
  personagem.img = LG.newImage('Insumos/Nave.png')

  imgDisparo = LG.newImage('Insumos/projetil.png')

  imgInimigo = LG.newImage('Insumos/Nave-inimiga.png')
  margemInimigo = imgInimigo:getWidth() / 2

  --Calculo para identificar o centro da tela referete a imagem--
  Meioh = (LG.getWidth() - personagem.img:getWidth()) / 2
  Meiov = (LG.getHeight() - personagem.img:getHeight()) / 2
  
  --Inicializar as posições do personagem--
  personagem.posX, personagem.posY = Meioh, Meiov

  -- Realizando a carga dos efeitos sonoros 
  Tiro = LA.newSource('Insumos/tiro.wav', 'static') 
  TiroTurbo = LA.newSource('Insumos/tirolaser.wav', 'static')
  Turbo = LA.newSource('Insumos/modoturbo.wav', 'static')
end

function love.draw()
  LG.draw(Fundo, 0, 0)

  -- Renderização personagem
  if Vivo then
    LG.draw(personagem.img, personagem.posX, personagem.posY)
  else
    LG.print("Pressione R para reiniciar ou ESC para sair!", LG.getWidth()/2 - 120, LG.getHeight()/2 - 20)
  end
  
  -- Renderização dos disparos
  for i, proj in ipairs(disparos) do
    LG.draw(imgDisparo, proj.x, proj.y)
  end

  -- Renderização dos inimigos
  for i, atual in ipairs(inimigos) do
    LG.draw(imgInimigo, atual.x, atual.y)
  end

  -- Montar um placar simples
  LG.setColor(1,1,1,1)
  LG.print("Pontos: " .. tostring(Pontos), 400, 10)
end

function  love.update(dt)
  -- Sair do jogo
  if (LK.isDown('escape')) then
    love.event.quit()
  end

  -- Reiniciar o jogo
  if (LK.isDown('r')) and not Vivo then
    Reiniciar()
  end

  --Movimentação
  if(LK.isDown("d", 'right')) and Vivo then
    if personagem.posX < (LG.getWidth() - personagem.img:getWidth()) then
      personagem.posX = personagem.posX + personagem.veloc * dt
    end
  elseif(LK.isDown("a", 'left')) and Vivo then
    if personagem.posX > 0 then
      personagem.posX = personagem.posX - personagem.veloc * dt
    end
  end  

  if ModoTurbo and Vivo then
    if LK.isDown('up', 'w') then
      if personagem.posY > (LG.getHeight() / 2) then
        personagem.posY = personagem.posY - personagem.veloc * dt
      end
    elseif LK.isDown('down', 's') then
      if personagem.posY < LG.getHeight() - personagem.img:getHeight() then
        personagem.posY = personagem.posY + personagem.veloc * dt
      end
    end
  end
  
  -- Controle de Temporização de Disparos
  TiroAtual = TiroAtual - (1 * dt)
  if TiroAtual < 0 then
    podeAtirar = true
  end

  -- Controle de Disparos
  if LK.isDown('space', 'rctrl', 'lctrl') and podeAtirar and Vivo then
    -- Criar uma instancia do projetil
    if not ModoTurbo then
      NvProjetil = {x = personagem.posX + personagem.img:getWidth() / 2, y = personagem.posY}
      table.insert(disparos, NvProjetil)
      -- Disparar o efeito sonoro do tiro normal
      Tiro:play()
    else
      local desloca = 30
      local n1Projetil = {x = personagem.posX + personagem.img:getWidth() / 2 - desloca, y = personagem.posY}
      local n2Projetil = {x = personagem.posX + personagem.img:getWidth() / 2 + desloca, y = personagem.posY}
      table.insert(disparos, n1Projetil)
      table.insert(disparos, n2Projetil)
      -- Disparar o efeito sonoro do tiro turbo
      TiroTurbo:play()
    end

    podeAtirar = false
    TiroAtual = tempoTiroMax
  end

  -- Animar o projetil do disparos 
  for i, proj in ipairs(disparos) do
    proj.y = proj.y - (250 * dt)

    -- Se sair da tela é preciso eliminar da tabela
    if (proj.y < 0) then
      table.remove(disparos, i)
    end
  end
  
  -- Temporizar inimigos 
  InimAtual = InimAtual - (.5 * dt)
  if (InimAtual < 0) then
    InimAtual = tempoInimMax

    -- Criar uma instancia de novo inimigo 
    math.randomseed(os.clock() * math.random())
    PosDinamica = math.random(10 + margemInimigo, LG.getWidth() - (10 + margemInimigo))
    NvInimigo = {x = PosDinamica, y = - 10}
    table.insert(inimigos, NvInimigo)
  end

  -- Animação dos inimigos
  for i, atual in ipairs(inimigos) do
    atual.y = atual.y + (velocInimigo * dt)

    -- Remover o inimigo se passar o final da tela
    if atual.y > LG.getHeight() then
      table.remove(inimigos, i)
    end
  end

  -- Detecção de colisões
  for i, vilao in ipairs(inimigos) do
    for j, proj in ipairs(disparos) do
      if VerColisao(vilao.x, vilao.y, imgInimigo:getWidth(), imgInimigo:getHeight(), proj.x, proj.y, imgDisparo:getWidth(), imgDisparo:getHeight()) then
        -- Existiu a colisão, remover da tabla
        table.remove(disparos, j)
        table.remove(inimigos, i) 
        Pontos = Pontos + 10

        -- Verificação para entrar no modo turbo
        -- ModoTurbo = (Pontos > 150)
        if Pontos > 150 and not ModoTurbo then
          ModoTurbo = true
          Turbo:play()
          velocInimigo = 300
        end
      end
    end
    -- Verificar se o inimigo colidiu com o personagem 
    if VerColisao(vilao.x, vilao.y, imgInimigo:getWidth(), imgInimigo:getHeight(), personagem.posX, personagem.posY, personagem.img:getWidth(), personagem.img:getHeight()) then
      -- Colidiu com o personagem
      table.remove(inimigos, i)
      Vivo = false
    end
  end
end

function VerColisao(x1, y1, w1, h1, x2, y2, w2, h2)
  return(x2+w2 >= x1 and x2 <= x1+w1 and y2+h2 >= y1 and y2 <= y1+h1)
end

function Reiniciar()
  -- Limpar as tabelas
  disparos = {}
  inimigos = {}

  -- Reiniciar os temporizadores
  TiroAtual = tempoTiroMax
  InimAtual = tempoInimMax

  -- Posiciona o jogador na posição inicial
  personagem.posX = Meioh
  personagem.posY = Meiov

  -- Reiniciar o placar
  Pontos = 0
  Vivo = true

  velocInimigo = 200
end
