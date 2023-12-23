pipeline{
    agent any
    stages{
        stage('Build BACKEND'){
            steps{
                sh 'mvn clean package -DskipTests=true'
            }
        }
        
    }
}
