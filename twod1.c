#include<stdio.h>
#include<math.h>
#include<graphics.h>
int i,pt[8]={150,150,210,150,210,100,150,150};
void trans();
void scale();
void reflect();
void shear();
void rotate();
int main(){
 int refpt[2] ={100,100};
 int gd=DETECT,gm;
 initgraph(&gd,&gm," ");
 setcolor(BLUE);
 for(i=0;i<7;i++){
  drawpoly(4,pt);
  }
 trans();
 shear();
 scale(refpt);
 reflect();
 rotate(refpt);
 closegraph();
 return 0;
}
void trans(){
 int p[8];
 int i,tx=0,ty=150;
 printf("Translation");
 for(i=0;i<8;i=i+2){
  p[i]=pt[i]+tx;
  p[i+1]=pt[i+1]+ty;
 }
 drawpoly(4,pt);
 drawpoly(4,p);
 getch();
 cleardevice();
}
void scale(int ref[]){
 int p[8],i;
 float sx=2,sy=2;
 printf("\t scaling");
 for(i=0;i<8;i=i+2){
  p[i]=ref[0]+(pt[i]-ref[0])*sx;
  p[i+1]=ref[1]+(pt[i+1]-ref[1])*sy;
 }
 drawpoly(4,pt);
 drawpoly(4,p);
 getch();
 cleardevice();
}
void shear(){
 int p[8];
 int i,shx=2,shy=2,xref=50,yref=50;
 printf("\t\t\t x direction shear w.r.t y refernce\n");
 for(i=0;i<8;i=i+2){
  p[i]=pt[i]+(pt[i+1]-yref)*shx;
  p[i+1]=pt[i+1];
 }
 line(0,yref,639,yref);
 drawpoly(4,pt);
 drawpoly(4,p);
 getch();
 cleardevice();
 setcolor(8);
 printf("\t\t\t y direction shear w.r.t x reference\n");
 for(i=0;i<8;i=i+2)
 {
  p[i]=pt[i];
  p[i+1]=pt[i+1]+(pt[i]-xref)*shy;
 }
 line(xref,0,xref,479);
 drawpoly(4,pt);
 drawpoly(4,p);
 getch();
 cleardevice();
}
void reflect()
{
 int p[8],i;
 printf("\t\t reflection w.r.t line x=y \n");
 for(i=0;i<8;i=i+2){
  p[i]=pt[i+1];
  p[i+1]=pt[i];
 }
 setcolor(3);
 drawpoly(4,pt);
 drawpoly(4,p);
 getch();
 cleardevice();
}
void rotate(int ref[]){
 int p[8];
 int a,i;
 float r;
 printf("\t\t\t rotation\n");
 printf("\t enter the degree to rotate the object:");
 scanf("%d",&a);
 r=(a*(3.14/180));
 setcolor(6);
 for(i=0;i<8;i=i+2){
  p[i]=ref[0]+((pt[i]-ref[0])*(cos(r)))-((pt[i+1]-ref[1])*(sin(r)));
  p[i+1]=ref[1]+((pt[i]-ref[0])*(sin(sin(r)))+((pt[i+1]-ref[1])*cos(r)));
 }
 drawpoly(4,pt);
 drawpoly(4,p);
 getch();
 cleardevice();
}
