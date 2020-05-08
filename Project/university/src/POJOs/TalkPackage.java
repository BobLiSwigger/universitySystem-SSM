package POJOs;

public class TalkPackage extends Package implements talkInterface, smsInterface{
    public int talkTime;
    public int smsCount;
    public TalkPackage(){
        super.price = 58;
        this.talkTime = 200;
        this.smsCount = 30;
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
}
