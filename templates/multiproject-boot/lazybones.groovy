def props = [:]
props.group = ask("Define value for 'group' [com.lifetouch]: ", "com.lifetouch", "group")
props.name = ask("Define value for 'name' [sample]: ", "sample", "name")
props.version = ask("Define value for 'version' [0.0.1]: ", "0.0.1", "version")
props.javaversion = ask("Define value for 'java version' [1.7]: ", "1.7", "javaversion")

processTemplates "api/build.gradle", props
processTemplates "client/build.gradle", props
processTemplates "service/build.gradle", props
processTemplates "build.gradle", props
processTemplates "settings.gradle", props


def apiDir = new File(projectDir, "api")
def newApiDir = new File(projectDir, "${props.name}-api")
apiDir.renameTo(newApiDir)

def clientDir = new File(projectDir, "client")
def newClientDir = new File(projectDir, "${props.name}-client")
clientDir.renameTo(newClientDir)

def serviceDir = new File(projectDir, "service")
def newServiceDir = new File(projectDir, "${props.name}-service")
serviceDir.renameTo(newServiceDir)

