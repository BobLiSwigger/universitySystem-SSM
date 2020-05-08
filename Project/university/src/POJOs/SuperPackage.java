package POJOs;

public class SuperPackage extends Package implements talkInterface, smsInterface, netInterface {
    public int talkTime;
    public int smsCount;
    public double flowCount;
    public SuperPackage(){
        super.price = 78;
        this.talkTime = 200;
        this.smsCount = 50;
        this.flowCount = 1;
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

    @Override
    public int consume_sms(int count) {
        if(this.smsCount>=count){
            this.smsCount=this.smsCount-count;
            return 0;
        }
        else{
            count=count-this.smsCount;
            this.smsCount=0;
            return count;
        }
    }

    @Override
    public int consume_talk(int time) {
        if(this.talkTime>=time) {
            this.talkTime = this.talkTime - time;
            return 0;
        }
        else{
            time=time-this.talkTime;
            this.talkTime=0;
            return time;
        }
    }
}
