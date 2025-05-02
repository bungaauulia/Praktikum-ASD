package Jobsheet9;

public class StackTugasMahasiswa04 {
    
    Mahasiswa04[] stack;
    int top;
    int size;

    public StackTugasMahasiswa04(int size) {
        this.size = size;
        stack = new Mahasiswa04[size];
        top = -1;
    }

    public boolean isEmpty() {
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(Mahasiswa04 mhs) {
        if (!isFull()) {
            top++;
            stack[top] = mhs;
        } else {
            System.out.println("Stack penuh! Tidak bisa menambahkan tugas lagi.");
        }
    }

    public boolean isFull() {
        if (top == size -1) {
            return true;
        } else {
            return false;
        }
    }

    public Mahasiswa04 pop() {
        if (!isEmpty()) {
            Mahasiswa04 m = stack[top];
            top--;
            return m;
        } else {
            System.out.println("Stack kosong. Tidak ada tugas untuk dinilai.");
            return null;
        }
    }

    public Mahasiswa04 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack kosong. Tidak ada tugas yang dikumpulkan");
            return null;
        }
    }

    public void print() {
        for (int i = top; i<= top; i--) {
            System.out.println(stack[i].nama + "\t" + stack[i].nim + "\t" + stack[i].kelas);
        }
        System.out.println("");
    }

    public Mahasiswa04 terbawah() {
        if (!isEmpty()) {
            return stack[0];
        } else {
            return null;
        }
    }

    public int jmlTugas() {
        return top +1;
    }
}
