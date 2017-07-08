#include<stdio.h>
#include<graphics.h>
#include<stdlib.h>
main(){
  float xwmin,xwmax,ywmax,ywmin;
  float xvmin,xvmax,yvmax,yvmin;
  float x[10],y[10],yv,xv,sx,sy;
  int gd=DETECT,gm,i;
  printf("\n Enter window port coordinates:\n(xwmin,ywmin,xwmax,ywmax):");
  scanf("%f%f%f%f",&xwmin,&ywmin,&xwmax,&ywmax);
  printf("\n Enter view port coordinates:\n(xvmin,yvmin,xvmax,yvmax):");
  scanf("%f%f%f%f",&xvmin,&yvmin,&xvmax,&yvmax);
  printf("\n Enter vertices for triangle");
  for(i=0;i<3;i++)
  {
   printf("\n Enter(x%d,y%d):",i,i);
   scanf("%f%f",&x[i],&y[i]);
  }
  sx=((xvmax-xvmin)/(xwmax-xwmin));
  sy=((yvmax-yvmin)/(ywmax-ywmin));
  initgraph(&gd,&gm,"");
  outtextxy(80,30,"windowport");
  rectangle(xwmin,ywmin,xwmax,ywmax);
  for(i=0;i<2;i++){
   line(x[i],y[i],x[i+1],y[i+1]);
  }
  line(x[2],y[2],x[0],y[0]);
  getch();
  cleardevice();
  for(i=0;i<3;i++)
  {
    x[i]=xvmin+((x[i]-xwmin)*sx);
    y[i]=yvmin+((y[i]-ywmin)*sy); 
  }
  outtextxy(150,10,"viewport");
  rectangle(xvmin,yvmin,xvmax,yvmax);
  for(i=0;i<2;i++){
   line(x[i],y[i],x[i+1],y[i+1]);
  }
  line(x[2],y[2],x[0],y[0]);
  getch();

}
