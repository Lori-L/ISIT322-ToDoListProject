import java.io.FileOutputStream
import java.io.ObjectOutputStream
import java.io.Serializable

class Task(val title: String, val description: String, val dueDate: String) : Serializable

class TaskFileManager {
    fun saveTask(task: Task, filename: String) {
        val fileOutputStream = FileOutputStream(filename)
        val objectOutputStream = ObjectOutputStream(fileOutputStream)
        objectOutputStream.writeObject(task)
        objectOutputStream.close()
        fileOutputStream.close()

        fun main() {
            val task = Task("Example Task", "This is an example task", "2023-06-01")
            val taskFileManager = TaskFileManager()
            taskFileManager.saveTask(task, "taskser")
        }

    }
}
