I = [ 1 0 ; 0 1];
sx = [ 0 1; 1 0];
O = [ 0 0 ; 0 0];

rp2 = [ cos(pi/2) sin(pi/2)
   	  sin(pi/2) -cos(pi/2) ]; 

x=[I O; O sx];
h=[1 1; 1 -1];

g = [ 
   
   1 0 0 0 0 0 0 1 
   0 1 0 0 0 0 1 0
   0 0 0 1 1 0 0 0 
   0 0 1 0 0 1 0 0 
   0 0 1 0 0 -1 0 0
   0 0 0 1 -1 0 0 0 
   0 1 0 0 0 0 -1 0 
   1 0 0 0 0 0 0 -1 
   
];

g = [
   I  O  O   sx
   O  I  sx  O
   O  sx -I  O
   sx O  O   -I  
];
