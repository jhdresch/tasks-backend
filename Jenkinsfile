def version_war
def context
def nameBuildDocker

pipeline{
    agent any
    stages{
        stage('Build BACKEND'){
            steps{
                sh 'mvn clean package -DskipTests=true'
                script {
                    version_war = sh( script:'mvn help:evaluate -Dexpression=project.version -q -DforceStdout',returnStdout: true).trim()
                    context = sh( script:'mvn help:evaluate -Dexpression=project.name -q -DforceStdout',returnStdout: true).trim()
                } 
              
                
               
                sh "echo !!! ${context}:${version_war}"  
                nameBuildDocker =  "${context}:${version_war}
            }
        }
        stage('TESTES UNITARIOS BACKEND'){
            steps{
                sh 'mvn test'
            }
        }
       
        stage("DEPLOY BACKEND") {
           
       
            steps {
                sh "docker build -t ${nameBuildDocker} ."
            }
        }
        
    }
    
}