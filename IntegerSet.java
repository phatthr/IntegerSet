import java.util.ArrayList;
/** ADT ที่เก็บตัวเลข แบบไม่ซ้ำกันและเรียงลำดับกัน 
 */
public class IntegerSet {
    ArrayList<Integer> Number ; // Rep
    // AF เซตของตัวเลขทั้งหมดจะต้องอยู่ใน Number
    // RI Number จะต้องเรียงลำดับจากน้อยไปมาก Number ต้องไม่ซ้ำกัน และต้องห้ามเป็น null 
    public IntegerSet(){
        Number = new ArrayList<>() ;
        CheckRep() ;
    }
    private void CheckRep() {
        if(Number == null)
            throw new RuntimeException("Number is null") ;
        if(Number.size() > 1){
            for (int i = 0 ; i < Number.size() -1 ; i++) {
                if(Number.get(i) >= Number.get(i+1))
                    throw new RuntimeException("error sort") ;
            }
        }
    }
    /**
     * @param x เอาไว้เพิ่มตัวเลข
     */
    public void add(Integer x){
        if(!Number.contains(x) && Number != null && x != null){
            if(Number.size() == 0){
                Number.add(x);
            }else{
                if(x < Number.get(0)){ //add ด้านหน้า
                    Number.add(0,x);
                }else{
                     for (int i = 0 ; i < Number.size() ; i++){ 
                        if(i == Number.size() -1){ //add ด้านหลัง
                            Number.add(x) ;
                            break ;
                        }
                        if(Number.get(i) < x && x < Number.get(i+1)){ //add ตรงกลาง
                        Number.add(i+1,x);
                        break ;
                        }
                    }
                }
            }
        }
        CheckRep();
    }
    public void remove(Integer x){ // ลบตัวเลข
        if(x == null)
            return ; 
            Number.remove(x) ;
            CheckRep();
    }
     /**
     * ตรวจสอบว่ามีตัวเลขนี้อยู่ในเซตหรือไม่
     * @param x ตัวเลขที่ต้องการตรวจสอบ
     * @return true หากมี x อยู่ในเซต, false หากไม่มี
     */
    public boolean contains(Integer x){ // ตรวจสอบตัวในเลขเซต
        return Number.contains(x) ;
    }
    /**
     * ขนาดของ Arr
     *
     * @return ส่งขนาดของ Arr กลับ
     */
    public int size(){ //ขนาดของ Arr 
        return Number.size();
    }
    public String toString(){
        return Number.toString() ;
    }
}