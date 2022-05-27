
# Emperor2K


## Introduction:

This is a single player basketball game where the player uses key commands to prompt their player to shoot the ball in the direction of the hoop. The space key is used to shoot the ball, the up and down arrows are used to move the ball, and the w and r keys are used to move the player. Once the player posesses the ball, one set of keys will be able to move both of the objects simultaneously.

![KeyPressed Code](https://user-images.githubusercontent.com/90531142/170742772-3279fc47-41c5-4037-b079-ba2ab0fda010.PNG)

## Basketball Class:

The basketball class features a hand-drawn basketball pixel, and it is coded for the ball to be moved in four directions. The movement of the ball is controlled by the up, down, right, and left arrows, and using these keys moves the ball in the corresponding direction. The ball is also equipped with collision detection, so that it is unable to leave the screen and go "out of bounds". When the ball collides with the player, the player posesses the ball, and the movement for both objects can be controlled with a singular set of keys.

![Basketball Code](https://user-images.githubusercontent.com/90531142/170741209-d27227dc-d523-48ea-8b3d-36f5bcaa3990.png)

![Hoop gif](https://user-images.githubusercontent.com/90531142/170743492-4ee2f714-0450-49ec-915a-2d8fe422e4ab.gif)

## Player Class:

This class features a hand-drawn player using pixel art, and that player is coded for two-directional movement. The movement of the player is controlled by the W and R keys, and similarly to the basketball class, the player sprite features collision detection, as well as collision with the ball, which groups the two sprites, allowing both objects to be control
ed using the W and R keys, or the up, down, left and right keys.

![Player Code](https://user-images.githubusercontent.com/90531142/170742773-9e517342-9783-4aa3-b2ba-d79db539e1bf.PNG)


## Hoop Class:

This class features two hand-drawn hoops using pixel art, and these hoops are automatically positioned at the right and left sides of the screen, using a coded coordinate system. These hoops do not move, however, when the ball passes through the hoop, one point is added to the score, by virtue of the scoring method. 

![Hoop Code](https://user-images.githubusercontent.com/90531142/170742771-bbb79037-9c75-429e-b0ba-8a872f7edf37.PNG)

![Untitled drawing (4)](https://user-images.githubusercontent.com/90531142/170739405-06f45fe1-0d44-4ab9-b6b8-c7c5fe7be4f1.png)

