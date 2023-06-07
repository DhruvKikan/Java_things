public class HW_04June {
    public boolean isSq(int num) {
        int a = (int) Math.sqrt(num);
        return (a * a == num);
    }

    public void opt_pytha() {
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                int sqrt=(int) Math.sqrt((i*i)+(j*j));
                if ((isSq((i * i) + (j * j))) && (sqrt)<=100) {
                    count+=1;
                    System.out.println(count + ". " + i + ", " + j + " and " + (sqrt) + " are Pythagorean Triplets");
                }
            }
        }
    }

    public boolean is_Narc(int num){
        int sum=0;
        int i=num;
        while(i!=0){
            sum+=((i%10)*(i%10)*(i%10));
            i/=10;
        }
        return(sum==num);
    }

    public void Narc_Seri(){
        for(int i=1; i<=1000; i++){
            if(is_Narc(i)){
                System.out.println((i+" is an Armstrong number"));
            }
        }
    }

    public static void main(String[] args) {
        HW_04June hw = new HW_04June();
        System.out.println();
        System.out.println(hw.isSq(50));
        System.out.println();
        hw.opt_pytha();
        System.out.println();
        hw.Narc_Seri();
    }
}


// Stack, List, Queue, Map and Warmup remains

/*
Stack<datatype_of_elements> stack_name = new Stack<datatype_of_elements>();

stack_name.push(var_of_given_datatype);
datatype popped_var_name = (datatype) stack_name.pop();
datatype peeked_var_name = (datatype) stack_name.peek();
datatype{generally Int} searched_elem_pos = (datatype) stack_name.search(element);

stack.isEmpty();

stack.addAll(int index{optional}, element/collection c);
stack.add(int index{optional}, element);


List<datatye_elem> list_name = new ArrayList<datatype_elem>();
list_name.add(int optional_index, element);
list_name.addAll(int optional_index, collection c);
list_name.remove(int index_of_removal);
list_name.remove(value_of_removal);
list_name.clear();
list_name.size();
datatype val_at_index = list_name.get(int index);
list_name.contains();
list_name.add();
list_name.add();
list_name.add();


map doubt why new for value assignment and not simply typecasting

 */