package Patterns.TemplateMethodPattern;

abstract class ModelTrainer {
    public final void trainPipeline(String dataPath) {
        loadData(dataPath);
        preProcessData();
        trainModel();
        evaluateModel();
        saveModel();
    }

    protected void loadData(String path) {
        System.out.println("[Common] loading dataset from: " + path);
    }

    protected void preProcessData() {
        System.out.println("[Common] Splitting into train/test and normalizing");
    }

    protected abstract void trainModel();
    protected abstract void evaluateModel();

    protected void saveModel() {
        System.out.println("[Common] Saving model to disk as default format");
    }

}

class NeuralNetworkTrainer extends ModelTrainer {
    @Override
    protected void trainModel() {
        System.out.println("[Neuralnet] Training Neural Network for 100 epochs");
    }

    @Override
    protected void evaluateModel() {
        System.out.println("[Neuralnet] Evaluating accuracy and losss on validation set");
    }

    @Override
    protected void saveModel() {
        System.out.println("[Neuralnet] Serializing network weights to .h5 file");
    }
}

class DecisionTreeTrainer extends ModelTrainer {
    @Override
    protected void trainModel() {
        System.out.println("[DecisionTree] Building decision tree with max_depth=5");
    }

    @Override
    protected void evaluateModel() {
        System.out.println("[DecisionTree] Computing classification report (precision/recall)");
    }
}

class TemplateMethodPattern {
    public static void main(String[] args) {
        System.out.println("=== Neural Network Taining ===");
        ModelTrainer nnTrainer = new NeuralNetworkTrainer();
        nnTrainer.trainPipeline("data/images/");

        System.out.println("\n=== Decision Tree Taining ===");
        ModelTrainer dtTrainer = new DecisionTreeTrainer();
        dtTrainer.trainPipeline("data/iris.csv");
    }
}
