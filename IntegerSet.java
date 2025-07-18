import java.util.ArrayList;

/**ADT ที่เก็บ Number แบบไม่ซ้ำกันและเรียงลำดับ
 */
public class IntegerSet {
    ArrayList<Integer> Numbers ; // Rep
    // (RI):
    // - x must not contain duplicate numbers.
    // - numbers in x must be sorted in ascending order.
    // (AF):
    // - AF(x) = the set of numbers in the Integer x.
    public IntegerSet (){
        Numbers = new ArrayList<>();
        checkRep();
    }
    //
    private void checkRep() {
        if(Numbers==null)
           throw new RuntimeException("Numbers is null");
        if(Numbers.size()>1){
            for(int i = 0 ; i < Numbers.size() - 1 ; i++){
                if(Numbers.get(i)>=Numbers.get(i+1))
                   throw new RuntimeException("Error set");
            }
        }
    }
    /** เพิ่มเลขเข้าเซต
     * @param x เลขที่ต้องการเพิ่ม
     */
    public void add(Integer x) {
        if(!Numbers.contains(x) && Numbers != null && x != null ){
            if(Numbers.size()==0){
                Numbers.add(x);
            } else {
                if(x < Numbers.get(0)){ //add ด้านหน้า
                    Numbers.add(0,x);
                } else {
                    for(int i=0 ; i<Numbers.size() ; i++){
                        if(i==Numbers.size()-1){ //add  ด้านหลัง
                        Numbers.add(x);
                        break;
                        }
                        if(Numbers.get(i)<x && x<Numbers.get(i+1)){ //add ตรงกลาง
                            Numbers.add(i+1,x);
                            break ;
                        }
                    }
                }
            }
        }
        CheckRep();
    }
    private void CheckRep() {
    }
    /** ลบเลขออกจากเซต
     *  @param x เลขที่ต้องการลบ
     */
    public void remove(Integer x) {
        if(x == null)
        return ;
        Numbers.remove(x);
        CheckRep();
        } 
    /**
     * ตรวจสอบว่ามีเลขนี้อยู่ในเซตหรือไม่
     * @param x เลขที่ต้องการตรวจสอบ
     * @return true หากมี x อยู่ในเซต, false หากไม่มี
     */
    public boolean contains(Integer x) {
        return Numbers.indexOf(x) != -1;
    }
    /**
     * คืนค่าขนาดของเซต
     * @return จำนวนสมาชิกในเซต
     */
    public int size() {
        return Numbers.size();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < Numbers.size(); i++) {
            sb.append(Numbers.get(i));
            if (i < Numbers.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}