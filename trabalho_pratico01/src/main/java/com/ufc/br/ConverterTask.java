package com.ufc.br;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConverterTask {
    private static Scanner entrada;
    private static List<Task> tasks;

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException {
        entrada = new Scanner(System.in);
        System.out.print("Nome do arquivo para ser convertido: ");
        String fileName = entrada.nextLine();
        tasks = convertToObjectList(fileName);
        saveTasksAsXml(tasks);
        saveTasksAsJson(tasks);
    }

    private static void saveTasksAsJson(List<Task> tasks) throws IOException {
        ObjectMapper om = new ObjectMapper();
        om.writeValue(new File("trabalho_pratico01/src/main/resources/tasks.json"), tasks);
        System.out.println("Convertion to json done!");
    }

    private static ArrayList<Task> convertToObjectList(String fileName) {
        ArrayList<Task> tasks = new ArrayList<>();
        InputStream inputStream = ConverterTask.class.getClassLoader().getResourceAsStream(fileName);
        Scanner entradaArquivo = new Scanner(inputStream);
        while (entradaArquivo.hasNextLine()) {
            Task task = readCsvLine(entradaArquivo.nextLine());
            tasks.add(task);
        }
        return tasks;
    }

    private static Task readCsvLine(String line) {
        String[] splitedTask = line.split(",");
        Task task = new Task();
        task.setId(Integer.parseInt(splitedTask[0]));
        task.setProject(splitedTask[1]);
        task.setSummary(splitedTask[2]);
        task.setDescription(splitedTask[3]);
        task.setType(splitedTask[4]);
        task.setTimeSpent(Double.parseDouble(splitedTask[5]));
        return task;
    }

    private static void saveTasksAsXml(List<Task> tasks) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.newDocument();
        Element rootElement = doc.createElement("tasks");
        doc.appendChild(rootElement);

        for (Task task: tasks) {
            Element taskElement = convertTaskToElement(task, doc);
            rootElement.appendChild(taskElement);
        }

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource domSource = new DOMSource(doc);
        StreamResult sr = new StreamResult(new File("trabalho_pratico01/src/main/resources/tasks.xml"));

        transformer.transform(domSource, sr);
        System.out.println("Convertion to xml done!");
    }

    private static Element convertTaskToElement(Task task, Document doc) {
        Element taskElement = doc.createElement("task");

        Attr idAttr = doc.createAttribute("id");
        idAttr.setValue(task.getId().toString());
        taskElement.setAttributeNode(idAttr);

        Element projectElement = doc.createElement("project");
        projectElement.appendChild(doc.createTextNode(task.getProject()));
        taskElement.appendChild(projectElement);

        Element summaryElement = doc.createElement("summary");
        summaryElement.appendChild(doc.createTextNode(task.getSummary()));
        taskElement.appendChild(summaryElement);

        Element descriptionElement = doc.createElement("description");
        descriptionElement.appendChild(doc.createTextNode(task.getDescription()));
        taskElement.appendChild(descriptionElement);

        Element typeElement = doc.createElement("type");
        typeElement.appendChild(doc.createTextNode(task.getType()));
        taskElement.appendChild(typeElement);

        Element timeSpentElement = doc.createElement("timeSpent");
        timeSpentElement.appendChild(doc.createTextNode(task.getTimeSpent().toString()));
        taskElement.appendChild(timeSpentElement);

        return taskElement;
    }
}
