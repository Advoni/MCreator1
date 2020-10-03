execute as @e store result score @s Y run data get entity @s Pos[1]
execute as @e[scores={Y=..-1}] at @s if data entity @s {Dimension:0} at @s in minecraft:the_nether run tp @s ~ 256 ~