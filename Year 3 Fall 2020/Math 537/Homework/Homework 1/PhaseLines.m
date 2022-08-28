clear				
figure(1)          
clf                 
hold off 

plot([-4 4],[0 0],'b');
grid on
hold on

ylim([-1,1])
plot([-2, 0, 2], 0,'o')
text(0-.1,-.25,'$x_c$', 'interpreter', 'latex')
text(-2-.45,-.25,'$-\sqrt{|\alpha|}$', 'interpreter', 'latex')
text(2-.25,-.25,'$\sqrt{|\alpha|}$', 'interpreter', 'latex')

plot(-3,0,'k>')
plot(-1,0,'k<')
plot(1,0,'k>')
plot(3,0,'k<')



