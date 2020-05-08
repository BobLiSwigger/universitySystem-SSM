package POJOs;

public class Card implements talkInterface, smsInterface, netInterface{
    public String phonenumber;
    public String username;
    public String password;
    public int pack;
    public double restmoney;
    public Package p;
    public double consumeOfMonth;

    public Card(){
        this.pack = 1;
        this.consumeOfMonth = 0;
    }

    public void setPhonenumber(String phonenumber){
        this.phonenumber = phonenumber;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setPack(int pack){
        this.pack = pack;
        switch (this.pack){
            case 1:
                this.p = new TalkPackage();
                break;
            case 2:
                this.p = new NetPackage();
                break;
            case 3:
                this.p = new SuperPackage();
                break;
            default:
                this.p = new TalkPackage();
        }
    }
    public void setRestmoney(double restmoney){
        this.restmoney = restmoney;
    }

    public String getPhonenumber(){
        return this.phonenumber;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public int getPack(){
        return this.pack;
    }
    public double getRestmoney(){
        return this.restmoney;
    }
    //重设Card
    public void reSet(Card card){
        this.phonenumber = card.phonenumber;
        this.username = card.username;
        this.password = card.password;
        this.pack = card.pack;
        this.restmoney = card.restmoney;
        switch (this.pack){
            case 1:
                this.p = new TalkPackage();
                break;
            case 2:
                this.p = new NetPackage();
                break;
            case 3:
                this.p = new SuperPackage();
                break;
            default:
                this.p = new TalkPackage();
        }
        this.consumeOfMonth = card.consumeOfMonth;
    }

    //打电话功能
    @Override
    public int consume_talk(int time) {
        if(p instanceof TalkPackage || p instanceof SuperPackage) {
            time=((talkInterface) p).consume_talk(time);
            this.restmoney = this.restmoney - time * 0.2;
            this.consumeOfMonth+=time*0.2;
            return 0;
        }
        else{
            this.restmoney=this.restmoney-time*0.2;
            this.consumeOfMonth+=time*0.2;
            return 0;
        }
    }
    //发短信功能
    @Override
    public int consume_sms(int count) {
        if(p instanceof TalkPackage || p instanceof SuperPackage){
            count=((smsInterface) p).consume_sms(count);
            this.restmoney=this.restmoney-count*0.1;
            this.consumeOfMonth+=count*0.1;
            return 0;
        }
        else{
            this.restmoney=this.restmoney-count*0.1;
            this.consumeOfMonth+=count*0.1;
            return 0;
        }
    }
    //上网功能
    @Override
    public double consume_net(double count) {
        if(p instanceof NetPackage || p instanceof SuperPackage){
            count=((netInterface) p).consume_net(count);
            this.restmoney=this.restmoney-count*102.4;
            this.consumeOfMonth+=count*102.4;
            return 0;
        }
        else{
            this.restmoney=this.restmoney-count*102.4;
            this.consumeOfMonth+=count*102.4;
            return 0;
        }
    }

}
