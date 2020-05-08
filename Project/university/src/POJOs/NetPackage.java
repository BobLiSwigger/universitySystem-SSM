package POJOs;

public class NetPackage extends Package implements netInterface {
    public double flowCount;
    public NetPackage(){
        super.price = 68;
        this.flowCount = 3;
    }
    @Override
    public double consume_net(double count) {
        if(this.flowCount>=count){
            this.flowCount=this.flowCount-count;
            return 0;
        }
        else{
            count=count-this.flowCount;
            this.flowCount=0;
            return count;
        }
    }
}
