def version_war
def context
def imageBack
pipeline{
    agent any
    stages{
        stage('Build BACKEND'){
            steps{
                sh 'mvn clean package -DskipTests=true'
                script {
                    version_war = sh( script:'mvn help:evaluate -Dexpression=project.version -q -DforceStdout',returnStdout: true).trim()
                    context = sh( script:'mvn help:evaluate -Dexpression=project.name -q -DforceStdout',returnStdout: true).trim()
                    imageBack = context+":"+version_war
                } 
                sh "echo ${imageBack}"              
               
               
            }
        }

        
    }
    
}
