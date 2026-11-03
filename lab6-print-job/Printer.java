import java.util.Queue;
import java.util.LinkedList;

// Stores information about a print job
class PrintJob {

    private String documentName;
    private int pageCount;

    // Constructor
    public PrintJob(String documentName, int pageCount) {
        this.documentName = documentName;
        this.pageCount = pageCount;
    }

    // Displays information about the print job
    @Override
    public String toString() {
        return "PrintJob[Document: " + documentName
                + ", Pages: " + pageCount + "]";
    }
}

// Manages print jobs using a queue
public class Printer {

    private Queue<PrintJob> jobQueue;

    // Creates an empty queue
    public Printer() {
        jobQueue = new LinkedList<>();
    }

    // Adds a job to the queue
    public void addJob(PrintJob job) {

        System.out.println("Adding to queue: " + job);

        jobQueue.add(job);
    }

    // Processes the next print job
    public void processNextJob() {

        // Check if queue is empty
        if (jobQueue.isEmpty()) {

            System.out.println("The print queue is empty.");

        } else {

            // Remove the first job
            PrintJob nextJob = jobQueue.remove();

            // Print the job information
            System.out.println("Processing: " + nextJob);
        }
    }

    public static void main(String[] args) {

        Printer officePrinter = new Printer();

        // Add print jobs
        officePrinter.addJob(new PrintJob("Annual_Report.pdf", 25));
        officePrinter.addJob(new PrintJob("Meeting_Agenda.docx", 2));
        officePrinter.addJob(new PrintJob("Presentation_Slides.pptx", 30));

        System.out.println("\n--- Starting to Print ---");

        // Process two jobs
        officePrinter.processNextJob();
        officePrinter.processNextJob();

        System.out.println("\nNew high-priority job arrives...");

        // Add another job
        officePrinter.addJob(new PrintJob("Urgent_Memo.pdf", 1));

        // Process remaining jobs
        officePrinter.processNextJob();
        officePrinter.processNextJob();

        // Check empty queue
        officePrinter.processNextJob();
    }
}