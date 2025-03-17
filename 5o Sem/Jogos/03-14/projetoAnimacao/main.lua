local posX = 0
local veloc = 100
local larg = 200

function love.load()
  love.graphics.setBackgroundColor(1,1,1)
end

function love.draw()
  love.graphics.setColor(1,0,0,1)
  love.graphics.line(0,0, 400,400)
  love.graphics.setColor(0,0,1,1)
  love.graphics.line(0, love.graphics.getHeight()/2, love.graphics.getWidth(), love.graphics.getHeight()/2)
  
  love.graphics.setColor(0,1,0,1)
  love.graphics.polygon('fill', {posX+10,100, posX+larg+10,100, posX+larg+10,100+larg, posX+10,100+larg})
end

function love.update(dt)
  if(posX < love.graphics.getWidth()) then
    posX = posX + veloc * dt
  else
    posX = -larg
  end
end
