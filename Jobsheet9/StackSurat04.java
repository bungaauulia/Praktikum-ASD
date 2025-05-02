package Jobsheet9;

public class StackSurat04 {

    Surat04[] stack;
    int top;
    int size;

    public StackSurat04(int size) {
        this.size = size;
        stack = new Surat04[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(Surat04 srt) {
        if (!isFull()) {
            top++;
            stack[top] = srt;
        } else {
            System.out.println("Stack penuh! Tidak bisa menambahkan surat lagi.");
        }
    }

    public Surat04 pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong. Tidak ada surat yang bisa diproses.");
            return null;
        }
        Surat04 srt = stack[top];
        top--;
        return srt;
    }

    public Surat04 peek() {
        if (isEmpty()) {
            System.out.println("Stack kosong. Tidak ada surat yang dikumpulkan");
            return null;
        }
        return stack[top];
    }

    public boolean cariSurat(String nama) {
        if (isEmpty()) {
            return false;
        }

        for (int i = top; i >= 0; i--) {
            if (stack[i].namaMahasiswa.equalsIgnoreCase(nama)) {
                return true;
            }
        }
        return false;
    }
}